# Utdanning Kodeverk Adapter

## Adapter credentials

Counties get their adapter credentials in one of two ways:

| County | beta | api |
|---|---|---|
| agderfk-no | FintAdapter | FintAdapter |
| mrfylke-no | FintAdapter | 1Password |
| nfk-no | FintAdapter | 1Password |
| rogfk-no | FintAdapter | FintAdapter |
| telemarkfylke-no | FintAdapter | 1Password |
| trondelagfylke-no | FintAdapter | FintAdapter |
| vestfoldfylke-no | FintAdapter | 1Password |

FintAdapter is unstable and we recommend against using it, so every new
deployment uses 1Password. Deployments that already ran on FintAdapter are left
as they are, so they don't have to change while they work. Talk to Flais before
moving one of them to 1Password or adding a new FintAdapter.

Both ways create a secret named `utdanning-kodeverk-adapter` with the same keys,
so the Application is the same for all counties.

- **FintAdapter:** finterator creates the secret from the `FintAdapter` resource
  in `kustomize/base/fint-adapter.yaml`.
- **1Password:** `onepassword-item.yaml` in the county's overlay creates the secret
  from the item `fint-utdanning-kodeverk-adapter-<county>`, for example
  `fint-utdanning-kodeverk-adapter-nfk-no`. The overlay also removes the
  `FintAdapter` that comes from base.

Database credentials are separate. All counties read them from the shared
1Password item `fint-utdanning-kodeverk-adapter` in the environment's vault, with
the fields `database.url`, `database.username` and `database.password`.

### Adding a county

1. Create the item `fint-utdanning-kodeverk-adapter-<county>` in the environment's
   vault (`aks-beta-vault` or `aks-api-vault`). Add these custom fields, and leave
   the built-in fields empty:
   - `fint.core.oauth2.username`
   - `fint.core.oauth2.password`
   - `fint.core.oauth2.client-id`
   - `fint.core.oauth2.client-secret`
2. Make sure the credentials have access to the `utdanning_kodeverk` component in
   that environment. A FintAdapter sets this up, but 1Password does not.
3. Copy `kustomize/overlays/api/nfk-no` to the new county and update the county
   name and `fint.fylkesnr`. In beta, also update the base URL and the vault.
